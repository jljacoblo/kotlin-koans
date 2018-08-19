package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
    : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (this.year - other.year) * 100000 +
                (this.month - other.month) * 1000 +
                (this.dayOfMonth - other.dayOfMonth)
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return this.addTimeIntervals(interval, 1)
}

operator fun MyDate.plus(interval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(interval.ti, interval.n)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, n)
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override operator fun contains(value: MyDate): Boolean{
        return value >= start && value <= endInclusive
    }

    override operator fun iterator(): Iterator<out MyDate> {
       return MyDateIterator(start, endInclusive)
    }
}

class MyDateIterator(val start: MyDate, val end: MyDate): Iterator<MyDate> {
    private var pointer: MyDate = start

    public override fun hasNext(): Boolean {
        return pointer <= end
    }

    public override fun next(): MyDate {
        val result = pointer
        pointer = pointer.nextDay()
        return result
    }
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)
