//
//  ContentViewModel.swift
//  SwiftUI-UserLocation
//
//  Created by ZanyZephyr on 2021/8/26.
//

import MapKit

enum MapDetail {
    
    static let defaultSpan = MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05)
    static let startingLocation = CLLocationCoordinate2D(latitude: 34.7568711, longitude: 113.663221)
}

final class ContentViewModel: NSObject, ObservableObject, CLLocationManagerDelegate {
    
    var locationManager: CLLocationManager?
    @Published var region = MKCoordinateRegion(center: MapDetail.startingLocation, span: MapDetail.defaultSpan)
    
    func checkIfLocationServiceIsEnabled() {
        if CLLocationManager.locationServicesEnabled() {
            locationManager = CLLocationManager()
            locationManager?.delegate = self
            checkLocationAuthorization()
        } else {
            print("请开启位置服务")
        }
    }
    
    func checkLocationAuthorization() {
        guard let locationManager = locationManager else { return }
        
        switch locationManager.authorizationStatus {
        
        case .notDetermined:
            locationManager.requestWhenInUseAuthorization()
        case .restricted:
            break
        case .denied:
            print("您没有授权位置权限")
        case .authorizedAlways, .authorizedWhenInUse:
            guard let coordinate = locationManager.location?.coordinate else { return }
            region = MKCoordinateRegion(center: .init(latitude: coordinate.latitude, longitude: coordinate.longitude), span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05))
        @unknown default:
            break
        }
    }
    
    func locationManagerDidChangeAuthorization(_ manager: CLLocationManager) {
        checkLocationAuthorization()
    }
}
