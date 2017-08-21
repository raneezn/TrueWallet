package com.raneez.truewallet;

import android.content.Context;

import com.raneez.truewallet.data.FakeLocalDataSource;
import com.raneez.truewallet.data.FakeRemoteDataSource;
import com.raneez.truewallet.data.source.TrueWalletDataRepository;
import com.raneez.truewallet.data.source.local.TrueWalletLocalDataRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class Injection {

    public static TrueWalletDataRepository provideTrueWalletRepository(Context context){
        checkNotNull(context);
        return TrueWalletDataRepository.getInstance(FakeLocalDataSource.getInstance(),
                FakeRemoteDataSource.getInstance());
    }
}
