package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack <Character> charS = new Stack<Character>();
		Stack <Character> charSPushPop = new Stack<Character>();
		char popped;
		int count = 0;
		for (int i = 0; i < b.length(); i++) {
			charS.push(b.charAt(i));
		}
		for (int i = 0; i < b.length(); i++) {
			charSPushPop.push(charS.pop());
		}
		for (int i = 0; i < b.length(); i++) {
			popped = charSPushPop.pop();
			if(popped == '{') {
				count++;
			} else {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		if(count != 0) {
			return false;
		}
		return true;
	}

}