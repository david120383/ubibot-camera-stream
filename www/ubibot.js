var exec = require('cordova/exec');

exports.getCameraStream = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'getCameraStream', [arg0]);
};

exports.stopCameraStream = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'stopCameraStream', [arg0]);
};

exports.getVersion = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'getVersion', [arg0]);
};
