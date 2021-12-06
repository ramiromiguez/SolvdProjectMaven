package com.solvd.gym.interfaces;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.Instructor;

@FunctionalInterface
public interface LongerString {
    public abstract int isLonger(Instructor instructor, Client client);
}
