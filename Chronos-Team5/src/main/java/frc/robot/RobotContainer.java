// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.StartIntake;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.Indexer.IndexerStates;


public class RobotContainer {
  private XboxController controller;
  private Trigger aButton;
  private Trigger bButton;
  private Trigger xButton;
  private Trigger yButton;

  private Trigger lTrigger;
  private Trigger rTrigger;
  
  private Joystick lJoystick;
  private Joystick rJoystick;

  //DPADSS??


  private Indexer s_Indexer;
  private Intake s_Intake;
  private Shooter s_Shooter;
  private Swervedrive s_Swervedrive;


  public RobotContainer() {

      s_Indexer = Indexer.getInstance();
      s_Intake = Intake.getInstance();
      s_Shooter = Shooter.getInstance();
      // s_Swervedrive = Swervedrive.getInstance();               **Implement swervedrive later**

    //Change port number
    controller = new XboxController(0);

    configureBindings();
  }

  private void configureBindings() {
      //xbox bindings
      aButton = new Trigger(() -> controller.getAButton());
      bButton = new Trigger(() -> controller.getBButton());
      xButton = new Trigger(() -> controller.getXButton());
      yButton = new Trigger(() -> controller.getYButton());

      lTrigger = new Trigger(() -> controller.getLeftBumper());
      rTrigger = new Trigger(() -> controller.getRightBumper());


      //placeholders; research actual command configuration
      aButton.onTrue(getAutonomousCommand());
      bButton.whileTrue(getAutonomousCommand());
      xButton.whileTrue(getAutonomousCommand());
      yButton.onTrue(getAutonomousCommand());
  }

  

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
