package OETPN.Project3.Exercise2;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lane_Intersection {

    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Lanes Intersection";

        pn.NetworkPort = 1080;

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);

        // -------------------------------------------------------------------
        // -------------------------------Lane1--------------------------------
        // --------------------------------------------------------------------

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1081" , "in");
        pn.PlaceList.add(OP1);

        DataCar P_a1 = new DataCar();
        P_a1.SetName("P_a1");
        pn.PlaceList.add(P_a1);

        DataCarQueue P_x1 = new DataCarQueue();
        P_x1.Value.Size = 3;
        P_x1.SetName("P_x1");
        pn.PlaceList.add(P_x1);

        DataString P_TL1 = new DataString();
        P_TL1.SetName("P_TL1");
        pn.PlaceList.add(P_TL1);


        DataCar P_b1 = new DataCar();
        P_b1.SetName("P_b1");
        pn.PlaceList.add(P_b1);

        // -------------------------------------------------------------------------------------
        // --------------------------------Lane2-----------------------------------------------
        // -------------------------------------------------------------------------------------

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1081" , "in");
        pn.PlaceList.add(OP2);

        DataCar P_a2 = new DataCar();
        P_a2.SetName("P_a2");
        pn.PlaceList.add(P_a2);

        DataCarQueue P_x2 = new DataCarQueue();
        P_x2.Value.Size = 3;
        P_x2.SetName("P_x2");
        pn.PlaceList.add(P_x2);

        DataString P_TL2 = new DataString();
        P_TL2.SetName("P_TL2");
        pn.PlaceList.add(P_TL2);


        DataCar P_b2 = new DataCar();
        P_b2.SetName("P_b2");
        pn.PlaceList.add(P_b2);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane3-----------------------------------------------
        // -------------------------------------------------------------------------------------

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1081" , "in");
        pn.PlaceList.add(OP3);

        DataCar P_a3 = new DataCar();
        P_a3.SetName("P_a3");
        pn.PlaceList.add(P_a3);

        DataCarQueue P_x3 = new DataCarQueue();
        P_x3.Value.Size = 3;
        P_x3.SetName("P_x3");
        pn.PlaceList.add(P_x3);

        DataString P_TL3 = new DataString();
        P_TL3.SetName("P_TL3");
        pn.PlaceList.add(P_TL3);


        DataCar P_b3 = new DataCar();
        P_b3.SetName("P_b3");
        pn.PlaceList.add(P_b3);

        // -------------------------------------------------------------------------------------
        // --------------------------------Lane4-----------------------------------------------
        // -------------------------------------------------------------------------------------

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost", "1081" , "in");
        pn.PlaceList.add(OP4);

        DataCar P_a4 = new DataCar();
        P_a4.SetName("P_a4");
        pn.PlaceList.add(P_a4);

        DataCarQueue P_x4 = new DataCarQueue();
        P_x4.Value.Size = 3;
        P_x4.SetName("P_x4");
        pn.PlaceList.add(P_x4);

        DataString P_TL4 = new DataString();
        P_TL4.SetName("P_TL4");
        pn.PlaceList.add(P_TL4);

        DataCar P_b4 = new DataCar();
        P_b4.SetName("P_b4");
        pn.PlaceList.add(P_b4);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 1-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_01 = new DataCarQueue(); //p17.Printable = false;
        P_01.Value.Size = 3;
        P_01.SetName("P_01");
        pn.PlaceList.add(P_01);

        DataCar P_01E = new DataCar(); //p18.Printable = false;
        P_01E.SetName("P_01E");
        pn.PlaceList.add(P_01E);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 2-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_02 = new DataCarQueue(); //p19.Printable = false;
        P_02.Value.Size = 3;
        P_02.SetName("P_02");
        pn.PlaceList.add(P_02);

        DataCar P_02E = new DataCar(); //p20.Printable = false;
        P_02E.SetName("P_02E");
        pn.PlaceList.add(P_02E);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 3-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_03 = new DataCarQueue(); //p21.Printable = false;
        P_03.Value.Size = 3;
        P_03.SetName("P_03");
        pn.PlaceList.add(P_03);

        DataCar P_03E = new DataCar(); //p22.Printable = false;
        P_03E.SetName("P_03E");
        pn.PlaceList.add(P_03E);

        // ----------------------------------------------------------------------------
        // ----------------------------Exit lane 4-------------------------------------
        // ----------------------------------------------------------------------------

        DataCarQueue P_04 = new DataCarQueue();
        P_04.Value.Size = 3;
        P_04.SetName("P_04");
        pn.PlaceList.add(P_04);

        DataCar P_04E = new DataCar();
        P_04E.SetName("P_04E");
        pn.PlaceList.add(P_04E);

        DataTransfer P04N = new DataTransfer();
        P04N.SetName("P04N");
        P04N.Value = new TransferOperation("localhost", "1081" , "P5");
        pn.PlaceList.add(P04N);


        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue P_I = new DataCarQueue();
        P_I.Value.Size = 3;
        P_I.SetName("P_I");
        pn.PlaceList.add(P_I);

        // T1 ------------------------------------------------
        PetriTransition t_u1 = new PetriTransition(pn);
        t_u1.TransitionName = "T_u1";
        t_u1.InputPlaceName.add("P_a1");
        t_u1.InputPlaceName.add("P_x1");

        Condition T1Ct1 = new Condition(t_u1, "P_a1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t_u1, "P_x1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t_u1, "P_a1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t_u1, "P_x1", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        t_u1.GuardMappingList.add(grdT1);

        GuardMapping grd2T1 = new GuardMapping();
        grd2T1.condition= T1Ct3;
        grd2T1.Activations.add(new Activation(t_u1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grd2T1.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.Move, "P_a1"));
        t_u1.GuardMappingList.add(grd2T1);

        t_u1.Delay = 0;
        pn.Transitions.add(t_u1);

        // T2 ------------------------------------------------
        PetriTransition t_e1 = new PetriTransition(pn);
        t_e1.TransitionName = "T_e1";
        t_e1.InputPlaceName.add("P_x1");
        t_e1.InputPlaceName.add("P_TL1");


        Condition T2Ct1 = new Condition(t_e1, "P_TL1", TransitionCondition.Equal,"green");
        Condition T2Ct2 = new Condition(t_e1, "P_x1", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t_e1, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdT2.Activations.add(new Activation(t_e1, "P_TL1", TransitionOperation.Move, "P_TL1"));

        t_e1.GuardMappingList.add(grdT2);

        t_e1.Delay = 0;
        pn.Transitions.add(t_e1);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T_u2";
        t3.InputPlaceName.add("P_a2");
        t3.InputPlaceName.add("P_x2");

        Condition T3Ct1 = new Condition(t3, "P_a2", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P_x2", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition T3Ct3 = new Condition(t3, "P_a2", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(t3, "P_x2", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);


        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P_a2", TransitionOperation.AddElement, "P_x2"));
        t3.GuardMappingList.add(grdT3);

        GuardMapping grd2T3 = new GuardMapping();
        grd2T3.condition= T3Ct3;
        grd2T3.Activations.add(new Activation(t3, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grd2T3.Activations.add(new Activation(t3, "P_a3", TransitionOperation.Move, "P_a3"));
        t3.GuardMappingList.add(grd2T3);

        t3.Delay = 0;
        pn.Transitions.add(t3);


    }
}
