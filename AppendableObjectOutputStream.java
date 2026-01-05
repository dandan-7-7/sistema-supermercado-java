import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
