package OETPN.Project3.Exercise1;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Lane {
    public static void main(String[] args) {

        //--------------------------------------------------------------------
        //-------------------------------Lane1--------------------------------
        //--------------------------------------------------------------------

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1080;

        DataTransfer OP = new DataTransfer();
        OP.SetName("OP");
        OP.Value = new TransferOperation("localhost", "1081" , "in");
        pn.PlaceList.add(OP);

        DataCar P_a = new DataCar();
        P_a.SetName("P_a");
        pn.PlaceList.add(P_a);

        DataCarQueue P_x = new DataCarQueue();
        P_x.Value.Size = 3;
        P_x.SetName("P_x");
        pn.PlaceList.add(P_x);

        DataString P_TL = new DataString();
        P_TL.SetName("P_TL");
        pn.PlaceList.add(P_TL);


        DataCar P_b = new DataCar();
        P_b.SetName("P_b");
        pn.PlaceList.add(P_b);

        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);


        DataString green= new DataString();
        green.SetName("green");
        green.SetValue("green");
        green.Printable= false;
        pn.ConstantPlaceList.add(green);



        // T1 ------------------------------------------------
        PetriTransition t_u = new PetriTransition(pn);
        t_u.TransitionName = "T_u";
        t_u.InputPlaceName.add("P_a");
        t_u.InputPlaceName.add("P_x");

        Condition T1Ct1 = new Condition(t_u, "P_a", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t_u, "P_x", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t_u, "P_a", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t_u, "P_x", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t_u, "P_a", TransitionOperation.AddElement, "P_x"));
        t_u.GuardMappingList.add(grdT1);

        GuardMapping grd2T1 = new GuardMapping();
        grd2T1.condition= T1Ct3;
        grd2T1.Activations.add(new Activation(t_u, "full", TransitionOperation.SendOverNetwork, "OP"));
        grd2T1.Activations.add(new Activation(t_u, "P_a", TransitionOperation.Move, "P_a"));
        t_u.GuardMappingList.add(grd2T1);

        t_u.Delay = 0;
        pn.Transitions.add(t_u);

        // T2 ------------------------------------------------
        PetriTransition t_e = new PetriTransition(pn);
        t_e.TransitionName = "T_e";
        t_e.InputPlaceName.add("P_x");
        t_e.InputPlaceName.add("P_TL");


        Condition T2Ct1 = new Condition(t_e, "P_TL", TransitionCondition.Equal,"green");
        Condition T2Ct2 = new Condition(t_e, "P_x", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t_e, "P_x", TransitionOperation.PopElementWithoutTarget, "P_b"));
        grdT2.Activations.add(new Activation(t_e, "P_TL", TransitionOperation.Move, "P_TL"));

        t_e.GuardMappingList.add(grdT2);

        t_e.Delay = 0;
        pn.Transitions.add(t_e);



        //-------------------------------------------------------------------------------------
        //----------------------------PN Start-------------------------------------------------
        //-------------------------------------------------------------------------------------

        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        //pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}


