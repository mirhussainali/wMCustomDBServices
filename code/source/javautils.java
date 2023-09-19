

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
// --- <<IS-END-IMPORTS>> ---

public final class javautils

{
	// ---( internal utility methods )---

	final static javautils _instance = new javautils();

	static javautils _newInstance() { return new javautils(); }

	static javautils _cast(Object o) { return (javautils)o; }

	// ---( server methods )---




	public static final void dateDiff (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(dateDiff)>> ---
		// @sigtype java 3.5
		// [i] object:0:required beforeDate
		// [i] object:0:required afterDate
		// [o] field:0:required elapsedMilliSec
		
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			Date	beforeDate = (Date)IDataUtil.get( pipelineCursor, "beforeDate" );
			Date	afterDate = (Date)IDataUtil.get( pipelineCursor, "afterDate" );
		pipelineCursor.destroy();
		
		long diff = afterDate.getTime() - beforeDate.getTime();
		String elapsedMilliSec = Long.toString(diff);
				
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "elapsedMilliSec", elapsedMilliSec );
		pipelineCursor_1.destroy();
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void multiConcat (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(multiConcat)>> ---
		// @sigtype java 3.5
		// [i] field:1:required inputList
		// [i] field:0:required separator
		// [o] field:0:required concatString
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
			String[]	inputList = IDataUtil.getStringArray( pipelineCursor, "inputList" );
			String	separator = IDataUtil.getString( pipelineCursor, "separator" );
		pipelineCursor.destroy();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inputList.length; i++) {
			sb.append(inputList[i]);
			if((i+1) < inputList.length)
				sb.append(separator);
		
		}
			
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "concatString", sb.toString() );
		pipelineCursor_1.destroy();
		
			
		// --- <<IS-END>> ---

                
	}



	public static final void stringToBigDecimal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(stringToBigDecimal)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inString
		// [o] object:0:required outBigDecimal
			
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	inString = IDataUtil.getString( pipelineCursor, "inString" );
		pipelineCursor.destroy();
		
		try {
			
			inString = inString.trim();
			final DecimalFormat format = new DecimalFormat();
			format.setParseBigDecimal(true);
			
		    final Number number = format.parse(inString);
		    BigDecimal outBigDecimal = new BigDecimal(number.toString());
		    
			IDataCursor pipelineCursor_1 = pipeline.getCursor();
			IDataUtil.put( pipelineCursor_1, "outBigDecimal", outBigDecimal );
			pipelineCursor_1.destroy();	
		  
		} catch (ParseException ignore) {
			throw new ServiceException("unable to convert value : " + inString);
		}
			
		// --- <<IS-END>> ---

                
	}
}

