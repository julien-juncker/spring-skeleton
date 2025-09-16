package com.spring.skeleton.infrastructure.pet;

import com.spring.skeleton.domain.petstore.entity.Pet;
import com.spring.skeleton.domain.petstore.port.PetPort;
import com.spring.skeleton.infrastructure.pet.mapper.PetDAOMapper;
import com.spring.skeleton.infrastructure.pet.repository.AddressRepository;
import com.spring.skeleton.infrastructure.pet.repository.OwnerRepository;
import com.spring.skeleton.infrastructure.pet.repository.PetRepository;
import org.springframework.stereotype.Component;

@Component
public class PetAdapter implements PetPort {

    private static final PetDAOMapper PET_DAO_MAPPER = PetDAOMapper.INSTANCE;
    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;

    public PetAdapter(final PetRepository petRepository, final OwnerRepository ownerRepository, final AddressRepository addressRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Pet registerPet(final Pet pet) {
        final var petDAO = PET_DAO_MAPPER.toDAO(pet);
        final var ownerDAO = petDAO.getOwner();
        final var addressDAO = petDAO.getOwner().getAddress();

        if (addressRepository.findByNumberAndStreetAndZip(addressDAO.getNumber(), addressDAO.getStreet(), addressDAO.getZip()).isEmpty()) {
            addressRepository.save(addressDAO);
        }

        if (ownerRepository.findByFirstNameAndLastName(ownerDAO.getFirstName(), ownerDAO.getLastName()).isEmpty()) {
            ownerRepository.save(ownerDAO);
        }

        final var registeredPetDAO = petRepository.save(petDAO);

        return PET_DAO_MAPPER.fromDAO(registeredPetDAO);
    }
}
