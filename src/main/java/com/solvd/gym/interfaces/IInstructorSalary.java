package com.solvd.gym.interfaces;

import com.solvd.gym.exception_container.ReceiveSalaryException;

public interface IInstructorSalary {
    void receiveSalary() throws ReceiveSalaryException;
}
