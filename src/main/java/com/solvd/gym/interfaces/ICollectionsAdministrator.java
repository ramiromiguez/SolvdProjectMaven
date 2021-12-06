package com.solvd.gym.interfaces;

import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.solvd.gym.data.Client;
import com.solvd.gym.data.ClientGym;
import com.solvd.gym.data.ClientYoga;
import com.solvd.gym.data.Instructor;
import com.solvd.gym.data.InstructorGym;
import com.solvd.gym.data.InstructorYoga;
import com.solvd.gym.genericlinkedlist.GenericLinkedList;

public interface ICollectionsAdministrator {

    public void addInstructorToTheCollection(InstructorYoga instructorYoga);

    public void addInstructorToTheCollection(InstructorGym instructorGym);

    public void addClientToTheCollection(ClientYoga client);

    public void addClientToTheCollection(ClientGym clientGym);

    public void eliminateInstructorFromTheCollection(InstructorYoga instructorYoga);

    public void eliminateInstructorFromTheCollection(InstructorGym instructorGym);

    public void eliminateClientFromTheCollection(ClientYoga clientYoga);

    public void eliminateClientFromTheCollection(ClientGym clientGym);

    public boolean isInstructorInTheCollection(InstructorYoga instructorYoga);

    public boolean isInstructorInTheCollection(InstructorGym instructorGym);

    public boolean isClientInTheCollection(ClientYoga clientYoga);

    public boolean isClientInTheCollection(ClientGym clientGym);

    public void printTotalCollection();

    public void printInstructorCollection();

    public void printInstructorYogaCollection();

    public void printInstrcutorGymCollection();

    public void printClientCollection();

    public void printClientYogaCollection();

    public void printClientGymCollection();

    public GenericLinkedList<Object> getTotalGenericLinkedList();

    public Queue<Instructor> getInstructorList();

    public Set<InstructorYoga> getInstructorYogaSet();

    public Set<InstructorGym> getInstructorGymSet();

    public List<Client> getClientList();

    public Set<ClientYoga> getClientYogaSet();

    public Set<ClientGym> getClientGymSet();

}
