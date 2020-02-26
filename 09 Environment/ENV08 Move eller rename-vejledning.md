# Move og rename-vejledning
## Move
1. Åben GitHub Desktop og vælg *Repository > Open in Command Prompt*

![Billede1](./Billeder_til_move_rename_procedure\billede1.png)

2. Brug kommandoen `git mv gammel_sti ny_sti` for at flytte en fil. Det samme kan gøres med hele mapper.

![Billede2](./Billeder_til_move_rename_procedure\billede2.png)

## Rename
Move og rename er reelt set det samme.

1. Åben GitHub Desktop og vælg *Repository > Open in Command Prompt*

![Billede1](./Billeder_til_move_rename_procedure\billede1.png)

2. Brug kommandoen `git mv gammelt_navn nyt_navn` for at omdøbe en fil. Det samme kan gøres med hele mapper.

![Billede3](./Billeder_til_move_rename_procedure\billede3.png)

## Hvorfor?
Hvorfor ikke bare omdøbe eller flytte filen direkte i filsystemet?

Når man gør dette svarer det til at slette filen og oprette den igen med det nye navn eller det nye sted.

![Billede4](./Billeder_til_move_rename_procedure\billede4.png)

Hvis man bruger `mv` kommandoen ser git det faktisk som at flytte filen, så man ikke mister filens historik.

![Billede5](./Billeder_til_move_rename_procedure\billede5.png)