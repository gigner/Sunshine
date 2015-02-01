package com.gigner.android.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends ActionBarActivity
{

  @Override
  protected void onCreate( final Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
    if ( savedInstanceState == null )
    {
      getSupportFragmentManager().beginTransaction()
              .add( R.id.container, new PlaceholderFragment() )
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
      return true;
    }

    return super.onOptionsItemSelected( item );
  }

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class PlaceholderFragment extends Fragment
  {

    public PlaceholderFragment()
    {
    }

    @Override
    public View onCreateView( final LayoutInflater inflater, final ViewGroup container,
                              final Bundle savedInstanceState )
    {
      return inflater.inflate( R.layout.fragment_main, container, false );
    }
  }
}
