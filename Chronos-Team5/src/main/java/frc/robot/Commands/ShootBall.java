package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Shooter.ShooterStates;

public class ShootBall extends Command{
    private Shooter s_Shooter;

    public ShootBall(Shooter shooter) {
        s_Shooter = shooter;
        addRequirements(s_Shooter);
    }

    public void initialize() {
        s_Shooter.setSpeed(ShooterStates.ON);
    }

    public void execute() {
        s_Shooter.shoot();
    }

    public void end(boolean b) {
        s_Shooter.stop();
        s_Shooter.setSpeed(ShooterStates.OFF);
    }

    public boolean isFinished() {
        
    }

}
