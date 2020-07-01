var exec = require('cordova/exec');

exports.start = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'start', [arg0]);
};

exports.stop = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'stop', [arg0]);
};

exports.getversion = function (arg0, success, error) {
    exec(success, error, 'ubibot', 'getversion', [arg0]);
};
