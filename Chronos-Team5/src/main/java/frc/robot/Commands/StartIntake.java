package frc.robot.Commands;

import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Intake.IntakeStates;

public class StartIntake {
    //This is just a sample command can change/remove later
    private Intake s_Intake;

    public void initialize() {
        s_Intake = new Intake();
        s_Intake.setVoltage(IntakeStates.ON);
    }

    public void execute() {
        
    }

    public void end(boolean b) {
        s_Intake.setVoltage(IntakeStates.OFF);
    }

    public void isFinished() {
        
    }

}
