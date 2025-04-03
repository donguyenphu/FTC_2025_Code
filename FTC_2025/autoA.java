package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "PlanAbasket (Blocks to Java)")
public class PlanAbasket extends LinearOpMode {

  private DcMotor motorControlDriveBaseRight;
  private Servo servoIntake;
  private DcMotor motorControlDriveBaseLeft;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    motorControlDriveBaseRight = hardwareMap.get(DcMotor.class, "motorControlDriveBaseRight");
    servoIntake = hardwareMap.get(Servo.class, "servoIntake");
    motorControlDriveBaseLeft = hardwareMap.get(DcMotor.class, "motorControlDriveBaseLeft");

    // Put initialization blocks here.
    motorControlDriveBaseRight.setDirection(DcMotor.Direction.REVERSE);
    servoIntake.setPosition(0);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      motorControlDriveBaseLeft.setPower(0.7);
      motorControlDriveBaseRight.setPower(0.7);
      sleep(1400);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      for (int count = 0; count < 2; count++) {
        motorControlDriveBaseLeft.setPower(0.7);
        motorControlDriveBaseRight.setPower(-0.7);
        sleep(250);
        motorControlDriveBaseLeft.setPower(0);
        motorControlDriveBaseRight.setPower(0);
        motorControlDriveBaseLeft.setPower(-0.7);
        motorControlDriveBaseRight.setPower(-0.7);
        sleep(2000);
        motorControlDriveBaseLeft.setPower(0);
        motorControlDriveBaseRight.setPower(0);
        motorControlDriveBaseLeft.setPower(0.7);
        motorControlDriveBaseRight.setPower(0.7);
        sleep(2000);
        motorControlDriveBaseLeft.setPower(0);
        motorControlDriveBaseRight.setPower(0);
      }
      motorControlDriveBaseLeft.setPower(-0.8);
      motorControlDriveBaseRight.setPower(0.4);
      sleep(1800);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      // rotate 180 deg to drop given sample
      motorControlDriveBaseLeft.setPower(-1);
      motorControlDriveBaseRight.setPower(1);
      sleep(1800);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      servoIntake.setPosition(0.5);
      motorControlDriveBaseLeft.setPower(-0.7);
      motorControlDriveBaseRight.setPower(0.7);
      sleep(150);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      motorControlDriveBaseLeft.setPower(1);
      motorControlDriveBaseRight.setPower(1);
      sleep(1500);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
    }
  }
}