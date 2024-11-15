// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.StartIntake;


public class RobotContainer {
  private XboxController controller;
  private Trigger aButton = new Trigger(null);
  private Trigger bButton = new Trigger(null);
  private Trigger xButton = new Trigger(null);
  private Trigger yButton = new Trigger(null);

  private Trigger lefTrigger = new Trigger(null);
  private Trigger rTrigger = new Trigger(null);
  
  private Joystick lJoystick = new Joystick(00);
  private Joystick rJoystick = new Joystick(000);

  public RobotContainer() {
    configureBindings();
    //Change port number
    controller = new XboxController(0);
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
