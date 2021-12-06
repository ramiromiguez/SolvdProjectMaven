package com.solvd.gym.data;

import com.solvd.gym.exception_container.NameContainNumberException;
import com.solvd.gym.exception_container.NullNameException;

public class ClientMartialArt extends Client {
    MartialArtType martialArtType;

    public ClientMartialArt(int id, String name, MartialArtType martialArtType)
	    throws NullNameException, NameContainNumberException {
	super(id, name);
	this.martialArtType = martialArtType;
    }

}
