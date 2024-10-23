/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.webdetails.cpf.web;

import java.io.IOException;
import java.io.InputStream;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;


public class DelegatingServletInputStream extends ServletInputStream  {
    private final InputStream sourceStream;
    
    /**
     * Create a new DelegatingServletInputStream.
     * @param sourceStream the sourceStream InputStream
     */
    
    public DelegatingServletInputStream(InputStream sourceStream) {
        this.sourceStream = sourceStream;
    }
    
    public InputStream getSourceStream() {
        return sourceStream;
    }
    
    
    public int read() throws IOException {
        return this.sourceStream.read();
    }

    
    public void close() throws IOException {
        super.close();
        this.sourceStream.close();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener( ReadListener readListener ) {

    }
}

