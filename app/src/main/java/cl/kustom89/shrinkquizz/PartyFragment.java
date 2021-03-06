package cl.kustom89.shrinkquizz;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class PartyFragment extends Fragment {


    public PartyFragment() {
                // Required empty public constructor
    }
    public static PartyFragment newInstance(){
        return new PartyFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_party, container, false );
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        final RadioGroup radioGroup = view.findViewById( R.id.partyRadioGroup );
        Button button= view.findViewById( R.id.partyBtn );

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=radioGroup.getCheckedRadioButtonId();

                //Reglas de negocio
                if(id != -1){
                    RadioButton radioButton=radioGroup.findViewById( id );
                    String answer=radioButton.getText().toString();
                    showDialog( answer );

                   // Toast.makeText( getContext(), answer, Toast.LENGTH_SHORT ).show();

                }else{
                    Toast.makeText( getContext(), "Debes Marcar una opcion", Toast.LENGTH_SHORT ).show();
                }



                Log.d("Radio Group", String.valueOf( radioGroup.getCheckedRadioButtonId() ) );
            }
        } );


    }
    private void showDialog(String answer){
        AlertDialog.Builder aletDialog= new AlertDialog.Builder( getActivity() );
        aletDialog.setTitle( "Nivel de Fiesta" );
        aletDialog.setMessage( new PartyResult( answer ).score());
        aletDialog.setPositiveButton( "YEAH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        } );
        aletDialog.show();
}}
