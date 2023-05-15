package com.gfg.jbdl.domain;

import java.io.Serializable;

public class Game implements Serializable {

    double serialVersionUID=12;
    double stage;
    transient Long timer; // this needs to be fresh on every start so intilized to 0
    double score;

    /*notes
    * */

}
