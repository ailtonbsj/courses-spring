package br.ailtonbsj.usermanagerdemo.exception.domain;

public class EmailExistException extends Exception {

    public EmailExistException(String msg) {
        super(msg);
    }
    
}
