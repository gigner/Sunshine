package com.gigner.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity
{
  Intent intent;
  String intentMessage;

  private ShareActionProvider shareActionProvider;

  @Override
  protected void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_detail );
    if ( savedInstanceState == null )
    {
      getSupportFragmentManager().beginTransaction()
              .add( R.id.container, new DetailFragment() )
              .commit();
    }
    intent = getIntent();
    intentMessage = intent.getStringExtra( Intent.EXTRA_TEXT );
  }


  @Override
  public boolean onCreateOptionsMenu( Menu menu )
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate( R.menu.menu_detail, menu );
    return true;
  }
/*
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate menu resource file.
    getMenuInflater().inflate(R.menu.share_menu, menu);

    // Locate MenuItem with ShareActionProvider
    MenuItem item = menu.findItem(R.id.menu_item_share);

    // Fetch and store ShareActionProvider
    mShareActionProvider = (ShareActionProvider) item.getActionProvider();

    // Return true to display menu
    return true;
}
 */
  @Override
  public boolean onOptionsItemSelected( MenuItem item )
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if ( id == R.id.action_settings )
    {
      startActivity( new Intent( this, SettingsActivity.class) );
      return true;
    }

    return super.onOptionsItemSelected( item );
  }

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class DetailFragment extends Fragment
  {
    private static final String LOG_TAG = DetailFragment.class.getSimpleName();
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String forecastString;


    public DetailFragment()
    {
      setHasOptionsMenu( true );
    }

    @Override
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater )
    {
      inflater.inflate( R.menu.detailfragment, menu );

      MenuItem item = menu.findItem(R.id.action_share );

      ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider( item );
      if (shareActionProvider != null)
      {
        shareActionProvider.setShareIntent( createShareIntent() );
      }
      else
      {
        Log.d( LOG_TAG, "Share action provider is null" );
      }

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState )
    {
      final Intent intent = getActivity().getIntent();
      final View rootView = inflater.inflate( R.layout.fragment_detail, container, false );
      if ( intent != null && intent.hasExtra( Intent.EXTRA_TEXT ) )
      {
        forecastString = intent.getStringExtra( Intent.EXTRA_TEXT );
        ((TextView)rootView.findViewById( R.id.detail_text )).setText( forecastString );
      }

      return rootView;
    }

    private Intent createShareIntent()
    {
      Intent shareIntent = new Intent( Intent.ACTION_SEND );
      shareIntent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET );
      shareIntent.setType( "text/plain" );
      shareIntent.putExtra( Intent.EXTRA_TEXT, forecastString + FORECAST_SHARE_HASHTAG );
      return shareIntent;
    }
  }
}