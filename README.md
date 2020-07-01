# cordova-plugin-ubibot-camera-stream

# UbibotCameraStream

> The `UbibotCameraStream` is to get the camera stream.

:warning: Report any issues on the [`UbibotCameraStream` issue tracker](https://github.com/david120383/ubibot-camera-stream/issues)

## Installation

This installation method requires cordova 5.0+

```bash
cordova plugin add cordova-plugin-ubibot-camera-stream
```

It possible to install via repo url directly.

```bash
cordova plugin add https://github.com/david120383/ubibot-camera-stream.git
```

## Methods

```javascript
const u = navigator.userAgent;
const isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1;
const isIOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
if (isAndroid == true) {
  arr = '***|***|***';
} else if (isIOS == true) {
  arr = ['***', '***', '***'];
}
// start get camera stream
cordova.plugins.ubibot.getCameraStream(arr, res => {
  console.log(res);
}, err => {
  console.log(err);
});
// stop get camera stream
cordova.plugins.ubibot.stopCameraStream('stopCameraStream', res => {
  console.log(res);
}, err => {
  console.log(err);
});
// get version
cordova.plugins.ubibot.getVersion('getVersion', res => {
  console.log(res);
}, err => {
  console.log(err);
});
```

#### Supported Platforms

* iOS
* Android
