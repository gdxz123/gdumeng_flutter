import Flutter
import UIKit

public class SwiftGdumengFlutterPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "gdumeng_flutter", binaryMessenger: registrar.messenger())
        let instance = SwiftGdumengFlutterPlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }

    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        if (call.method == "getPlatformVersion") {
            result("iOS " + UIDevice.current.systemVersion)
        } else if (call.method == "makeup") {
            self.makeup(call: call)
            result("")
        } else {
            result(FlutterMethodNotImplemented)
        }
    }
    
    private func makeup(call: FlutterMethodCall) {
        let result = [GdumengFlutterPlugin .makeupAnalysic(call)];
        debugPrint(result)
    }
}
