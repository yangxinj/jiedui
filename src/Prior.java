
public class Prior {
	public static int prior(char c)
	{
		if (c == '(')
			return 0;
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;
		return -1;
	}
}
