package com.raneez.truewallet;

import android.content.Context;

import com.raneez.truewallet.data.source.TrueWalletDataRepository;
import com.raneez.truewallet.data.source.local.TrueWalletLocalDataRepository;
import com.raneez.truewallet.data.source.remote.TrueWalletRemoteDataRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by raneezahmed on 20/08/17.
 */

public class Injection {

    public static TrueWalletDataRepository provideTrueWalletRepository(Context context){
        checkNotNull(context);
        return TrueWalletDataRepository.getInstance(TrueWalletLocalDataRepository.getInstance(context),
                TrueWalletRemoteDataRepository.getInstance());
    }
}
