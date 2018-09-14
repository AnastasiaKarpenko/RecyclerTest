package com.example.karpena2.recyclertest;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class PhoneNumberLoader extends AsyncTaskLoader<String> {
    private String mContactId;
    private Context mContext;
    private String mNumber;


    public PhoneNumberLoader(@NonNull Context context, String contactId) {
        super(context);
        mContext = context;
        mContactId = contactId;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        Cursor cursor = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = ?",
                new String[]{mContactId, String.valueOf(ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)},
                null);

        if (cursor != null && cursor.moveToFirst()) {
            mNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            cursor.close();

        }

        return mNumber;
    }
}
