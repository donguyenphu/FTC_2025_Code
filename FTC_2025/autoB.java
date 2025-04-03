package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "PlanBpulltoobserzone (Blocks to Java)", preselectTeleOp = "Test2")
public class PlanBpulltoobserzone extends LinearOpMode {

  private DcMotor motorControlDriveBaseRight;
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
    motorControlDriveBaseLeft = hardwareMap.get(DcMotor.class, "motorControlDriveBaseLeft");

    // Put initialization blocks here.
    motorControlDriveBaseRight.setDirection(DcMotor.Direction.REVERSE);
    motorControlDriveBaseLeft.setPower(0);
    motorControlDriveBaseRight.setPower(0);
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      motorControlDriveBaseLeft.setPower(0.5);
      motorControlDriveBaseRight.setPower(0.5);
      sleep(700);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      motorControlDriveBaseLeft.setPower(0.5);
      motorControlDriveBaseRight.setPower(-0.5);
      sleep(1000);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      motorControlDriveBaseLeft.setPower(0.5);
      motorControlDriveBaseRight.setPower(0.5);
      sleep(1500);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      motorControlDriveBaseLeft.setPower(-0.5);
      motorControlDriveBaseRight.setPower(0.5);
      sleep(1000);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
      motorControlDriveBaseLeft.setPower(-0.5);
      motorControlDriveBaseRight.setPower(-0.5);
      sleep(1000);
      motorControlDriveBaseLeft.setPower(0);
      motorControlDriveBaseRight.setPower(0);
    }
  }
}