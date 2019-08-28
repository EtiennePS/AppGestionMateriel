package com.example.gestionmateriel.presentation.detailclient;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Contact;
import com.example.gestionmateriel.presentation.ajoutcontact.AjoutContactActivity;
import com.example.gestionmateriel.repository.ClientRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {
    private RecyclerView recyclerViewContact;


    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contacts_layout, container, false);
        DetailClientActivity activity = (DetailClientActivity) getActivity();
        Client c = activity.getClient();

       recyclerViewContact = (RecyclerView) root.findViewById(R.id.recyclerViewContacts);
       recyclerViewContact.setLayoutManager(new LinearLayoutManager(activity));
       recyclerViewContact.setAdapter( new ListeContactsAdapter(c.getContacts()) {});

       FloatingActionButton ajoutC = root.findViewById(R.id.ajoutContact);
       ajoutC.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
               Intent i = new Intent(getActivity(), AjoutContactActivity.class);
               startActivity(i);
           }
       });

       return root;
   }

    private class ContactViewHolder extends RecyclerView.ViewHolder {
        private Contact contact;
        private TextView nomContact;
        private TextView fonctionContact;
        private TextView prenomContact;
        private TextView mailContact;
        private TextView telContact;


        //itemView est la vue correspondante à 1 cellule
        public ContactViewHolder(final View itemView) {
            super(itemView);

            //c'est ici que l'on fait nos findView

            nomContact = (TextView) itemView.findViewById(R.id.nomContact);
            prenomContact = (TextView) itemView.findViewById(R.id.prenomContact);
            fonctionContact = (TextView) itemView.findViewById(R.id.fonctionContact);
            telContact = (TextView) itemView.findViewById(R.id.telContact);
            mailContact = (TextView) itemView.findViewById(R.id.mailContact);

        }

        public void bindContact(Contact contact) {
            nomContact.setText(contact.getPersonne().getNom());
            prenomContact.setText(contact.getPersonne().getPrenom());
            fonctionContact.setText(contact.getFonction().getLibelle());
            mailContact.setText(contact.getPersonne().getEmail());
            telContact.setText(contact.getPersonne().getTelephone());
            this.contact = contact;


            mailContact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { mailContact.getText().toString() });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "GestionClient: ");
                    startActivity(Intent.createChooser(intent, ""));
                }
            });
            telContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", telContact.getText().toString());
                startActivity(smsIntent);
            }
        });


        }
    }

    private  class ListeContactsAdapter extends RecyclerView.Adapter<ContactViewHolder>
    {
        List<Contact> listContact;
        public ListeContactsAdapter(List<Contact> list) {
            this.listContact  = (list == null ? new ArrayList<Contact>() : list);
        }

        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liste_contacts_layout,viewGroup,false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ContactViewHolder myViewHolder, int position) {
            Contact contact = listContact.get(position);
            myViewHolder.bindContact(contact);
        }

        @Override
        public int getItemCount() {
            return listContact.size();
        }

    }


}

