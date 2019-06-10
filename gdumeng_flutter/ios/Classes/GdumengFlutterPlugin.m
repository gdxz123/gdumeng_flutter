#import "GdumengFlutterPlugin.h"
#import <gdumeng_flutter/gdumeng_flutter-Swift.h>
#import "UMMobClick/MobClick.h"

@implementation GdumengFlutterPlugin

+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    [SwiftGdumengFlutterPlugin registerWithRegistrar:registrar];
}

+ (bool)makeupAnalysic:(FlutterMethodCall *)call {
    UMConfigInstance.appKey = call.arguments[@"key"];
    
    NSString* channel = call.arguments[@"channel"];
    if (channel) UMConfigInstance.channelId = channel;
    
    [MobClick startWithConfigure:UMConfigInstance];
    return YES;
}
@end
