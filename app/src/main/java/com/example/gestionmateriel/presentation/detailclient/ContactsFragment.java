package com.example.gestionmateriel.presentation.detailclient;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gestionmateriel.R;
import com.example.gestionmateriel.entite.Client;
import com.example.gestionmateriel.entite.Contact;
import com.example.gestionmateriel.repository.ClientRepository;

import java.util.List;

public class ContactsFragment extends Fragment {

    private RecyclerView recyclerViewContact;

       @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contacts_layout, container, false);
        DetailClientActivity activity = (DetailClientActivity) getActivity();
        Client c = activity.getClient();
        c.getContacts();
        new ListeContactsAdapter(c.getContacts());

           recyclerViewContact = (RecyclerView) root.findViewById(R.id.recyclerViewContacts);
           recyclerViewContact.setLayoutManager(new LinearLayoutManager(activity));
           recyclerViewContact.setAdapter( new ListeContactsAdapter(c.getContacts()) {});
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
        public void bindContact(Contact contact){
            nomContact.setText(contact.getNom());
            prenomContact.setText(contact.getPrenom());
            fonctionContact.setText(contact.getFonction()+"");
            mailContact.setText(contact.getEmail());
            telContact.setText(contact.getTelephone());
            this.contact = contact;
        }



    }

    private  class ListeContactsAdapter extends RecyclerView.Adapter<ContactViewHolder>
    {
        List<Contact> listContact;
        public ListeContactsAdapter(List<Contact> list) {
            this.listContact = list;
        }



        @Override
        public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liste_contacts_layout,viewGroup,false);
            return new ContactViewHolder(view);
        }

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

