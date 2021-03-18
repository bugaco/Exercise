import UIKit
import PlaygroundSupport

public protocol TrafficLightOption {
    associatedtype Value

    /// 默认的选项值
    static var defaultValue: Value { get }
}

extension TrafficLight {
    public enum GreenLightColor: TrafficLightOption {
        case green
        case turquoise

        public static let defaultValue: GreenLightColor = .green
    }
}

extension TrafficLight {
    public var preferredGreenLightColor: TrafficLight.GreenLightColor {
        get { self[option: GreenLightColor.self] }
        set { self[option: GreenLightColor.self] = newValue }
    }
}

public class TrafficLight {

    public enum State {
        case stop
        case proceed
        case caution
    }

    private var options = [ObjectIdentifier: Any]()

    public subscript<T: TrafficLightOption>(option type: T.Type) -> T.Value {
        get {
            options[ObjectIdentifier(type)] as? T.Value
                ?? type.defaultValue
        }
        set {
            options[ObjectIdentifier(type)] = newValue
        }
    }

    public private(set) var state: State = .stop {
        didSet { onStateChanged?(state) }
    }

    public var onStateChanged: ((State) -> Void)?

    public var stopDuration = 4.0
    public var proceedDuration = 6.0
    public var cautionDuration = 1.5

    private var timer: Timer?

    public func start() {
        guard timer == nil else { return }
        turnState(.stop)
    }

    public func stop() {
        timer?.invalidate()
        timer = nil
    }

    private func turnState(_ state: State) {
        switch state {
        case .proceed:
            timer = Timer.scheduledTimer(withTimeInterval: proceedDuration, repeats: false) { _ in
                self.turnState(.caution)
            }
        case .caution:
            timer = Timer.scheduledTimer(withTimeInterval: cautionDuration, repeats: false) { _ in
                self.turnState(.stop)
            }
        case .stop:
            timer = Timer.scheduledTimer(withTimeInterval: stopDuration, repeats: false) { _ in
                self.turnState(.proceed)
            }
        }
        self.state = state
    }
}


class MyViewController : UIViewController {

    var light: TrafficLight!

    override func loadView() {
        let view = UIView()
        view.backgroundColor = .white
        self.view = view

        light = TrafficLight()
        light.preferredGreenLightColor = .turquoise
        light.onStateChanged = { [weak self, weak light] state in
            guard let self = self, let light = light else { return }
            let color: UIColor
            switch state {
            case .proceed: color = light.preferredGreenLightColor.color
            case .caution: color = .yellow
            case .stop: color = .red
            }
            UIView.animate(withDuration: 0.25) {
                self.view.backgroundColor = color
            }
        }
        light.start()
    }

    deinit {
        light.stop()
    }
}


extension TrafficLight.GreenLightColor {
    var color: UIColor {
        switch self {
        case .green: return .green
        case .turquoise: return UIColor(red: 0.25, green: 0.88, blue: 0.82, alpha: 1.00)
        }
    }
}
// Present the view controller in the Live View window
PlaygroundPage.current.liveView = MyViewController()
