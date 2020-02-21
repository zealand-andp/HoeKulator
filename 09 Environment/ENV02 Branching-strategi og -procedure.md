# Branching-strategi
1. Projektet "lever" i master. <br>
   Der må ikke committes halvfærdigt arbejde eller kode der ikke kan kompilere til master.

2. Opgaver løses i separate branches, som navngives efter opgaven. <br>
   Opgave-branches slettes når opgaven er afsluttet.

3. Eksperimenter udføres i separate branches, som navngives beskrivende for eksperimentet. <br>
   Eksperiment-branches bevares såfremt der kan være læringsværdi i senere at kigge på deres indhold.

# Branching-procedure
1. Opret en ny branch fra master ved start på ny opgave
2. Navngiv branch efter opgaven, fx "Opret-UC01-Beregn-omsætning"
3. Commit løbende dokumenter m.m. til branchen jf. [ENV03 Commit-procedure](https://github.com/zealand-andp/HoeKulator/blob/master/09%20Environment/ENV03%20Commit-procedure.md)
4. Når opgaven er afsluttet så merges branchen ind i master jf. [ENV01 Merge-procedure](https://github.com/zealand-andp/HoeKulator/blob/master/09%20Environment/ENV01%20Merge-procedure.md)
5. Slet branch efter succesfuld merging
