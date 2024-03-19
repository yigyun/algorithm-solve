package leetcode.Array_String.medium;


// 시간내에 못풀어서 정답 확인
class ZigzagConversion_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        int index = 0;
        int direction = 1;

        for (char c : s.toCharArray()) {
            sb[index].append(c);
            if (index == 0) direction = 1;
            else if (index == numRows - 1) direction = -1;
            index += direction;
        }

        String result = "";
        for (StringBuilder stringBuilder : sb) result += stringBuilder.toString();

        return result;
    }
}