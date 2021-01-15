import java.util.Arrays;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MeetingRoom {

	public static void main(String[] args) {

		Interval int1 = new Interval(0, 30);
		Interval int2 = new Interval(5, 10);
		Interval int3 = new Interval(15, 20);

		Interval[] intervals = { int1, int2, int3 };
		Arrays.parallelSort(intervals, comp);

		print(intervals);
		System.out.println(solve(intervals));

	}

	public static boolean solve(Interval[] intervals) {

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}

		return true;

	}

	public static Comparator<Interval> comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}

	};

	public static void print(Interval[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start + " " + in.end);
		}
	}

}