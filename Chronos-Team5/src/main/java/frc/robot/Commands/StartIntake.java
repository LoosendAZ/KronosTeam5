package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Intake.IntakeStates;

public class StartIntake extends Command{
    //This is just a sample command can change/remove later
    private Intake s_Intake;

    public StartIntake(Intake.IntakeStates iStates) {
        s_Intake = Intake.getInstance();
        addRequirements(s_Intake);
    }

    public void initialize() {
        s_Intake.setSpeed(IntakeStates.ON);
    }

    public void execute() {

    }

    public void end(boolean b) {
        s_Intake.setSpeed(IntakeStates.OFF);
        s_Intake.setVoltage(0);
    }

    public boolean isFinished() {
        if(true) {
            return true;
        }

        return false;
    }

}
