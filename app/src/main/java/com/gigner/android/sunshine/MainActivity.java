package com.gigner.android.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    ArrayAdapter<String> forecastAdapter;

    public PlaceholderFragment()
    {
    }

    @Override
    public View onCreateView( final LayoutInflater inflater, final ViewGroup container,
                              final Bundle savedInstanceState )
    {
      final View rootView = inflater.inflate( R.layout.fragment_main, container, false );

      final String forecastArray[] = {
              "Today - Sunny - 88/63",
              "Tomorrow - Foggy - 70/46",
              "Wed - Foggy - 72/63",
              "Thur - Cloudy - 62/51",
              "Fri - Rainy - 72/46",
              "Sat - Foggy - 76/68",
              "Sun - Sunny - 88/68"
      };
      final List<String> weekForecast = new ArrayList<>( Arrays.asList(forecastArray));
      forecastAdapter =
              new ArrayAdapter<>( getActivity(),
                      R.layout.list_item_forcast, R.id.list_item_forcast_textview, weekForecast );
      final ListView listView = (ListView)rootView.findViewById( R.id.listview_forecast );
      listView.setAdapter( forecastAdapter );


      return rootView;
    }
  }
}
