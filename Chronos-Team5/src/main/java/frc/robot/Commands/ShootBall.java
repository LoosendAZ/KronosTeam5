package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Shooter.ShooterStates;

public class ShootBall extends Command{
    private Shooter s_Shooter;
    private Shooter.ShooterStates sState;

    public ShootBall(Shooter.ShooterStates sState) {
        s_Shooter = Shooter.getInstance();
        addRequirements(s_Shooter);
    }

    public void initialize() {
        s_Shooter.setSpeed(ShooterStates.ON);
    }

    public void execute() {

    }

    public void end(boolean b) {
        // s_Shooter.stop();
        s_Shooter.setSpeed(ShooterStates.OFF);
    }

    public boolean isFinished() {
        //idk what to put here
        if(true) {
            return true;
        }
        return false;
    }

}
