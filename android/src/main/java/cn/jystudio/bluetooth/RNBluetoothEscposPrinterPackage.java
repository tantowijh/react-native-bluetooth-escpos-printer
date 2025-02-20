package cn.jystudio.bluetooth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import cn.jystudio.bluetooth.escpos.RNBluetoothEscposPrinterModule;
import cn.jystudio.bluetooth.tsc.RNBluetoothTscPrinterModule;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

public class RNBluetoothEscposPrinterPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        BluetoothService service = new BluetoothService(reactContext);
        return Arrays.<NativeModule>asList(
                new RNBluetoothManagerModule(reactContext, service),
                new RNBluetoothEscposPrinterModule(reactContext, service),
                new RNBluetoothTscPrinterModule(reactContext, service)
        );
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}