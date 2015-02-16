package com.gigner.android.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by gigne_000 on 16/02/2015.
 */
public class PreferenceUtil
{
  public static String getPreferedLocation( final Context context)
  {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
    return sharedPreferences.getString( context.getString( R.string.pref_location_key ),
            context.getString( R.string.pref_location_default ) );
  }

  public static String getPreferedUnits( final Context context)
  {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences( context );
    return sharedPreferences.getString( context.getString( R.string.pref_units_key ),
            context.getString( R.string.pref_units_default ) );
  }
}
