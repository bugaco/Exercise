UIImageView用Kingfisher加载图片时报错：

```
Job failed: Retrieving resource succeeded, but this source is not the one currently expected. Result: RetrieveImageResult(image: <UIImage:0x2828bf9f0 anonymous {1199, 674}>, 
cacheType: Kingfisher.CacheType.none, 
source: Kingfisher.Source.network(https://p0.ssl.img.360kuai.com/t0105ab9de8e1c622d7.jpg),
originalSource: Kingfisher.Source.network(https://p0.ssl.img.360kuai.com/t0105ab9de8e1c622d7.jpg)).
Resource: network(https://p0.ssl.img.360kuai.com/t0105ab9de8e1c622d7.jpg).
```

解决方法：

> 在cell从屏幕滚出的时候，取消下载图片

```
    func tableView(_ tableView: UITableView, didEndDisplaying cell: UITableViewCell, forRowAt indexPath: IndexPath) {
				cell.cancelDownloadImage()
    }
```



参考：https://github.com/onevcat/Kingfisher/issues/1438#issuecomment-617201849

