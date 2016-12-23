package com.example.aqua.contactmanager;

import android.support.v7.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by aqua on 12/22/2016.
 */

public class ContactDAO {
    private static Realm realm = Realm.getDefaultInstance();
    public static boolean insert(String name,String no,String email,String address)
    {
        if(name.length()!=0 && no.length()!=0 && email.length()!=0 && address.length()!=0) {


            realm.beginTransaction();
            Contact contact = realm.createObject(Contact.class);
            contact.setName(name);
            contact.setPhone(no);
            contact.setEmail(email);
            contact.setAddress(address);
            realm.commitTransaction();
            return true;
        }else {
            return false;
        }
    }

    public static boolean update(String name,String phone,String email,String address)
    {
        if(name.length()!=0 && phone.length()!=0 && email.length()!=0 && address.length()!=0) {


            realm.beginTransaction();
            Contact contact = realm.where(Contact.class).equalTo("name", name).findFirst();
            contact.setPhone(phone);
            contact.setEmail(email);
            contact.setAddress(address);
            realm.commitTransaction();
            return true;
        }
        else
        {
            return false;
        }
    }

    public static RealmResults<Contact> select()
    {

        RealmResults<Contact> realmResults=realm.where(Contact.class).findAll();
        return  realmResults;
    }

    public static boolean delete(String name)
    {
        if(name.length()!=0 )
            {
                realm.beginTransaction();
                Contact contact=realm.where(Contact.class).equalTo("name",name).findFirst();
                contact.deleteFromRealm();
                realm.commitTransaction();


                return true;
            }
        else {

            return true;
        }
    }
    public static void notifyDataChanged(RecyclerviewAdapter adapter)
    {
        adapter.notifyDataSetChanged();
    }
}
