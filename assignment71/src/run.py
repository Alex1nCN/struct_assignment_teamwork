class Master:
    def __init__(self, power):
        self.power = power
        self.time = 1
        self.sonList = []

    def getPower(self):
        return self.power * self.time


def setPower(clan, master, r):
    global sumPower
    i = 0
    while i < len(master.sonList):
        master2 = clan[master.sonList[i]]
        master2.power = master.getPower() * (100.0 - r) / 100.0
        if master2.time != 1:
            sumPower += master2.getPower()
        setPower(clan, master2, r)
        i += 1


if __name__ == "__main__":
    sumPower = 0.0
    s = input().split(" ")
    N = int(s[0])
    Z = float(s[1])
    r = float(s[2])

    clan = [Master(0) for _ in range(N)]

    for i in range(N):
        s = input().split()
        n = int(s[0])
        if n == 0:
            clan[i].time = int(s[1])
            continue
        for j in range(n):
            clan[i].sonList.append(int(s[j+1]))

    clan[0].power = Z
    setPower(clan, clan[0], r)
    print(int(sumPower))