package Utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class AppiumServer {


    public static void startServer () {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress ("127.0.0.1")
                .usingPort (4723)
                .withAppiumJS (
                        new File ("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable (new File("/opt/homebrew/bin/node"))
                .withArgument (BASEPATH, "/wd/hub")
                .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument (GeneralServerFlag.LOG_LEVEL, "debug");

        AppiumDriverLocalService server = AppiumDriverLocalService.buildService(builder);
        server.start();
    }
}
