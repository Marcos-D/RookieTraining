/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  private static TalonSRX m_rightParent;
  private static TalonSRX m_rightChild1;
  private static TalonSRX m_rightChild2;
  private static TalonSRX m_leftParent;
  private static TalonSRX m_leftChild1;
  private static TalonSRX m_leftChild2;

  public Drive() {
    m_rightParent = new TalonSRX(0);
    m_rightChild1 = new TalonSRX(1);
    m_rightChild2 = new TalonSRX(2);
    m_leftParent = new TalonSRX(3);
    m_leftChild1 = new TalonSRX(4);
    m_leftChild2 = new TalonSRX(5);
      
    m_leftChild1.follow(m_leftParent);
    m_leftChild2.follow(m_leftParent);
    m_rightChild1.follow(m_rightParent);
    m_rightChild2.follow(m_rightParent);
    
    m_leftParent.setInverted(true);
    m_rightParent.setInverted(false); //play with this when running robot
  }

  public void setPower(double leftPower, double rightPower){ //(-1,1) that depicts voltage from -12 to 12 V.
    m_leftParent.set(ControlMode.PercentOutput, leftPower); 
    m_rightParent.set(ControlMode.PercentOutput, rightPower); 
  }

  @Override
  public void periodic() { //every 0.02 seconds
    // This method will be called once per scheduler run
  }
}
