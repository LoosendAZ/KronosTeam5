package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.Constants;
import frc.robot.Subsystems.Swervedrive;

public class Drive extends Command{
    private Swervedrive swervedrive = new Swervedrive();

    public Drive() {
    }


    @Override
    public void initialize() {
        Constants.Drive.driveAngle = 1 * Math.PI;
        Constants.Drive.driveSpeed = 2;
    }
    
    @Override
    public void execute(){
        swervedrive.move();
    }

    @Override
    public void end(boolean interrupted) {
        Constants.Drive.driveAngle = 3 * Math.PI;
        Constants.Drive.driveSpeed = 6;
    }

    @Override
    public boolean isFinished() {
        if(true) {

        }
        return false;
    }
}
