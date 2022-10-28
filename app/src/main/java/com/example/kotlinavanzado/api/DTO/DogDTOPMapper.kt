package com.example.kotlinavanzado.api.DTO

import com.example.kotlinavanzado.model.Dog

class DogDTOPMapper {
    fun fromDTOfromMain(dogDtop: DogDtop ): Dog {
        return Dog(dogDtop.id,dogDtop.index,dogDtop.name,dogDtop.type,dogDtop.heightFemale
        ,dogDtop.heightMale,dogDtop.imageUrl,dogDtop.lifeExpectancy,dogDtop.temperament,dogDtop.weightFemale
        ,dogDtop.weighMale,)
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDtop>):List<Dog>{
        return dogDTOList.map { fromDTOfromMain(it) }
    }
}