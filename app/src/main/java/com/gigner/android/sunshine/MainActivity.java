package com.gigner.android.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity
{
  private final String LOG_TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate( final Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
    if ( savedInstanceState == null )
    {
      getSupportFragmentManager().beginTransaction()
              .add( R.id.container, new ForecastFragment() )
              .commit();
    }
  }


  @Override
  public boolean onCreateOptionsMenu( final Menu menu )
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate( R.menu.menu_main, menu );
    return true;
  }

  @Override
  public boolean onOptionsItemSelected( final MenuItem item )
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    final int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if ( id == R.id.action_settings )
    {
      startActivity( new Intent( this, SettingsActivity.class) );
      return true;
    }
    else if ( id == R.id.action_show_in_map )
    {
      final Intent intent = new Intent( Intent.ACTION_VIEW );

      final Uri uri = Uri.parse( "geo:0,0" ).buildUpon().appendQueryParameter( "q", PreferenceUtil.getPreferedLocation( this ) ).build();
//        final String uri = "geo:0,0?q=" + URLEncoder.encode( PreferenceUtil.getPreferedLocation( this ), "utf-8" );

      intent.setData( uri );
      if ( intent.resolveActivity( getPackageManager() ) != null )
      {
        startActivity( intent );
      }
      else
      {
        Log.d( LOG_TAG, "Could not open map for location" );
      }
      return true;
    }

    return super.onOptionsItemSelected( item );
  }

}
