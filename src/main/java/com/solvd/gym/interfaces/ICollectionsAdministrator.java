package com.solvd.gym.interfaces;

import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientMartialArt;
import com.solvd.gym.data.ClientWeightLifter;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorMartialArt;
import com.solvd.gym.data.InstructorWeightLifter;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.genericlinkedlist.GenericLinkedList;

public interface ICollectionsAdministrator {

    public void addInstructorToTheCollection(InstructorYoga instructorYoga);

    public void addInstructorToTheCollection(InstructorGym instructorGym);

    public void addInstructorToTheCollection(InstructorWeightLifter instructorWeightLifter);

    public void addInstructorToTheCollection(InstructorMartialArt instructorMartialArt);

    public void addClientToTheCollection(ClientYoga client);

    public void addClientToTheCollection(ClientGym clientGym);

    public void addClientToTheCollection(ClientWeightLifter clientWeightLifter);

    public void addClientToTheCollection(ClientMartialArt clientMartialArt);

    public void eliminateInstructorFromTheCollection(InstructorYoga instructorYoga);

    public void eliminateInstructorFromTheCollection(InstructorGym instructorGym);

    public void eliminateInstructorFromTheCollection(InstructorWeightLifter instructorWeightLifter);

    public void eliminateInstructorFromTheCollection(InstructorMartialArt instructorMartialArt);

    public void eliminateClientFromTheCollection(ClientYoga clientYoga);

    public void eliminateClientFromTheCollection(ClientGym clientGym);

    public void eliminateClientFromTheCollection(ClientWeightLifter clientWeightLifter);

    public void eliminateClientFromTheCollection(ClientMartialArt clientMartialArt);

    public boolean isInstructorInTheCollection(InstructorYoga instructorYoga);

    public boolean isInstructorInTheCollection(InstructorGym instructorGym);

    public boolean isInstructorInTheCollection(InstructorWeightLifter instructorWeightLifter);

    public boolean isInstructorInTheCollection(InstructorMartialArt instructorMartialArt);

    public boolean isClientInTheCollection(ClientYoga clientYoga);

    public boolean isClientInTheCollection(ClientGym clientGym);

    public boolean isClientInTheCollection(ClientWeightLifter clientWeightLifter);

    public boolean isClientInTheCollection(ClientMartialArt clientMartialArt);

    public void printTotalCollection();

    public void printInstructorCollection();

    public void printInstructorYogaCollection();

    public void printInstrcutorGymCollection();

    public void printInstructorWeightLifter();

    public void printInstructorMartialArt();

    public void printClientCollection();

    public void printClientYogaCollection();

    public void printClientGymCollection();

    public void printClientWeightLifterCollection();

    public void printClientMartialArtCollection();

    public GenericLinkedList<Object> getTotalGenericLinkedList();

    public Queue<Instructor> getInstructorList();

    public Set<InstructorYoga> getInstructorYogaSet();

    public Set<InstructorWeightLifter> getInstructorWeightLifterSet();

    public Set<InstructorMartialArt> getInstructorMartialArtSet();

    public Set<InstructorGym> getInstructorGymSet();

    public List<Client> getClientList();

    public Set<ClientYoga> getClientYogaSet();

    public Set<ClientGym> getClientGymSet();

    public Set<ClientWeightLifter> getClientWeightLifterSet();

    public Set<ClientMartialArt> getClientMartialArtSet();

}
